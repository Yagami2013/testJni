//
// Created by hj on 2018/10/15.
//
#include "../jni/yangtt_personal_testjni_Java2CJNI.h"
extern "C"
JNIEXPORT jstring JNICALL Java_yangtt_personal_testjni_1saas_Java2CJNI_java2c
        (JNIEnv *env, jobject instance,jint num)
{
    char str[num];
    for(int i=0;i<num;i++){
        str[i] = '*';
    }
    return env->NewStringUTF(str);
}

