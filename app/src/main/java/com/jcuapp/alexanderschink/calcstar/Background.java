package com.jcuapp.alexanderschink.calcstar;


class Background {
    public static void run(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
