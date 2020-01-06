package com.hsdroid.harish.truecallerusingsqlite;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CountDownTimer;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class IncomingCall extends BroadcastReceiver {

    DatabaseHelper databaseHelper;

    @Override
    public void onReceive(final Context context, final Intent intent) {

        try {
            System.out.println("Receiver start");
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                databaseHelper = new DatabaseHelper(context);
                String query = "SELECT * FROM teachers WHERE phone=" + incomingNumber ;
                SQLiteDatabase db = databaseHelper.getReadableDatabase();
                Cursor cursor = db.rawQuery(query, null);

                if (cursor.moveToFirst()) {
                    String a = cursor.getString(cursor.getColumnIndex("name"));
                    toast(context,a,incomingNumber,state);

                } else {
                    Toast.makeText(context,"Not exists",Toast.LENGTH_SHORT).show();

                }
                cursor.close();
            }



        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public void toast(Context context, String a, String incomingNumber, String state)
    {
        final Toast toast = new Toast(context);
        View view = LayoutInflater.from(context).inflate(R.layout.custom_toast, null);
        TextView textView = (TextView) view.findViewById(R.id.custom_toast_text);
        TextView number = (TextView) view.findViewById(R.id.number);
        textView.setText(a);
        number.setText(incomingNumber);
        toast.setView(view);
        toast.setGravity(Gravity.CENTER|Gravity.FILL_HORIZONTAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();



            new CountDownTimer(6000, 1000) {
                public void onTick(long millisUntilFinished) {
                    toast.show();
                }

                public void onFinish() {
                    toast.show();
                }

            }.start();


    }


    }
