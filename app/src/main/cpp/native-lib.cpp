#include <jni.h>
#include <string>

extern "C"

JNIEXPORT jstring

JNICALL

Java_yangtt_personal_testjni_AC_Crash_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {

/*    std::string hello = "nothing";
    hello[9] = 1;
    return env->NewStringUTF(hello.c_str());*/
    char str[5];
    str[5] = '!';
    return env->NewStringUTF(str);
}
