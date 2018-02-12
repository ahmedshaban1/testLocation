package mivors.testlocation.Services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


/**
 * Created by Ahmed shaban on 1/13/2018.
 */

public class MReceiver extends BroadcastReceiver {

    public static final int REQUEST_CODE = 2155;

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent in = new Intent(context, MyLocationService.class);
        context.startService(in);

        Intent intent1 = new Intent(context, MReceiver.class);
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(context, MReceiver.REQUEST_CODE, intent1, 0);
        final AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        MyLocationService.LOCATION_INTERVAL =  5000;
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+5000, pendingIntent);






    }
}