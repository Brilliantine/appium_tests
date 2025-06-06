package ru.rzd.permission;

import java.io.IOException;

public class PermissionManager {
    //Выдача разрешений, чтобы не всплывало окно запроса местоположения
    public static void grantNotificationPermission(){
        try {
            Runtime.getRuntime().exec("adb shell pm grant ru.rzd.pass.debug android.permission.POST_NOTIFICATIONS");
            Runtime.getRuntime().exec("adb shell pm grant ru.rzd.pass.debug android.permission.ACCESS_FINE_LOCATION");
            Runtime.getRuntime().exec("adb shell pm grant ru.rzd.pass.debug android.permission.ACCESS_COARSE_LOCATION");
            System.out.println("Все необходимые разрешения выданы через ADB");
        }
        catch (IOException exception){
            System.out.println("Ошибка при выдаче разрешения через ADB "+exception.getMessage());
        }
    }
}
