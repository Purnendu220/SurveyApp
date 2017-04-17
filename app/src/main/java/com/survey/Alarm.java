package com.survey;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class Alarm extends BroadcastReceiver {
    Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wl.acquire();
        CollectionPageTableDao collectionPageTableDao = new CollectionPageTableDao(DatabaseHelper.getDatabase());
        Log.e("hdhfgdsj", collectionPageTableDao.getSize() + " this is size");
        if (checkInternet()) {
            if (collectionPageTableDao.getSize() > 0) {
                String userdetail = "";
                List<CollectionPageTableModel> nlist = collectionPageTableDao.getList();
                for (int i = 0; i < nlist.size(); i++) {
                    CollectionPageTableModel collectionPageTableModel = nlist.get(i);
                    if (!AppPreference.getInstance().getstatus(collectionPageTableModel.getFamily_time())) {
                        userdetail = userdetail + GsonManager.toJSON(collectionPageTableModel) + "\n";
                        AppPreference.getInstance().setStatus(collectionPageTableModel.getFamily_time());
                    }

                        senddata task = new senddata(collectionPageTableModel);
                        task.execute();

                }
                sendmailtask task = new sendmailtask(userdetail);
                task.execute();
            }
        }
        wl.release();
    }

    public void setAlarm(Context context) {
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, Alarm.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 60 * 20, pi); // Millisec * Second * Minute
    }

    public void cancelAlarm(Context context) {
        Intent intent = new Intent(context, Alarm.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }

    class sendmailtask extends AsyncTask<Void, Void, Void> {

        String message;

        public sendmailtask(String message) {
            this.message = message;
        }

        @Override
        protected Void doInBackground(Void... params) {
            sendemail(message);
            return null;
        }
    }
    class senddata extends AsyncTask<Void,Void,Void>{

        CollectionPageTableModel message;

        public senddata(CollectionPageTableModel message) {
            this.message = message;
        }

        @Override
        protected Void doInBackground(Void... params) {
            if (!AppPreference.getInstance().getstatus(message.getFamily_time()+""+message.getFamily_time())) {
                RefrenceWrapper.getRefrenceWrapper(mContext).getmServiceCallHandler().userRegistration(mContext,message);

            }

            return null;
        }
    }
    public void sendemail(String message) {
        /*source,desti,child,adult,budget,
		departuredate,arrivaldate,enqry,tur,claa,type*/
        Mail m = new Mail("purendu220@gmail.com", "9532633477pm@");
        //Mail m = new Mail(user, password);
//String mail="purendu220@gmail.com";
        String[] toArr = {"anoop.yadav005@gmail.com","purnendu5059@gmail.com"}; // This is an array, you can add more emails, just separate them with a coma
        m.setTo(toArr); // load array to setTo function
        m.setFrom("purendu220@gmail.com"); // who is sending the email
        m.setSubject("Saved User Data");
        m.setBody(message);

        try {
            //m.addAttachment("/sdcard/myPicture.jpg");  // path to file you want to attach
            if (m.send()) {
                // success
                //Toast.makeText(Plan.this, "Email was sent successfully.", Toast.LENGTH_LONG).show();
            } else {
                // failure
                //	Toast.makeText(Plan.this, "Email was not sent.", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            AppPreference.getInstance().ClearPRef();
            // some other problem
            //Toast.makeText(Plan.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show();
        }


    }

    public boolean checkInternet() {
        try {
            if (NetworkUtils.isConnectingToInternet(mContext)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Syso.error(e);
            return false;
        }
    }
}