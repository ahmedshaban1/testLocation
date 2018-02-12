package mivors.testlocation;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mivors.testlocation.Services.MReceiver;

public class LocationWithServicesAndReciver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_with_services_and_reciver);

        Intent intent = new Intent(getApplicationContext(), MReceiver.class);
        final PendingIntent pIntent = PendingIntent.getBroadcast(this, MReceiver.REQUEST_CODE,intent, PendingIntent.FLAG_UPDATE_CURRENT);
        long firstMillis = System.currentTimeMillis();
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarm.set(AlarmManager.RTC_WAKEUP, firstMillis+5000, pIntent);



    }
}
