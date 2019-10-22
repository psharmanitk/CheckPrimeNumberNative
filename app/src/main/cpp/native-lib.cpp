#include <jni.h>
#include <string>
#include <math.h>

extern "C" JNIEXPORT jboolean JNICALL
Java_app_albums_android_com_myapplication_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */, jlong num) {
    jlong x;
    jdouble tempNum = sqrt(num);
    jboolean isPrime= true;
    for( x = 2; x <= tempNum ; x++)
    {
        if ((num%x) == 0)
            isPrime = false;
    }
    return isPrime;
    //return env->NewStringUTF(hello.c_str());
}
