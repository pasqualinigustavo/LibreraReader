#!/usr/bin/env bash
#. ~/.profile

cd jni-1.11

export ANDROID_SDK=/Users/pasqualini/Library/Android/sdk
export ANDROID_NDK=/Users/pasqualini/Library/Android/sdk/ndk/16.1.4479499
export PATH="$PATH:$ANDROID_SDK/tools:$ANDROID_SDK/platform-tools:$ANDROID_NDK"

MUPDF_ROOT=/Users/pasqualini/Projetos/LibreraReader/Builder/mupdf-1.11
OTHER_MU=/Users/pasqualini/Projetos/LibreraReader/Builder/jni-1.11
#MUPDF_ROOT=/Users/pasqualini/Projetos/LibreraReader/Builder/jni-1.11

MUPDF_JAVA=$OTHER_MU

export NDK_PROJECT_PATH=$MUPDF_JAVA
#export TOP_LOCAL_PATH=/Users/pasqualini/Projetos/LibreraReader
#export LOCAL_PATH=/Users/pasqualini/Projetos/LibreraReader

#LIBS=/Users/pasqualini/Projetos/LibreraReader/app/src/main/jniLibs
#
#ln -s $MUPDF_JAVA/libs/armeabi-v7a $LIBS
#ln -s $MUPDF_JAVA/libs/arm64-v8a $LIBS
#ln -s $MUPDF_JAVA/libs/x86 $LIBS
#ln -s $MUPDF_JAVA/libs/x86_64 $LIBS


cp -rp jni-1.11/~mupdf/epub-doc.c $MUPDF_ROOT/source/html/epub-doc.c
#cp -rp jni-1.11/~mupdf/css-apply.c $MUPDF_ROOT/source/html/css-apply.c
#cp -rp jni-1.11/~mupdf/html-layout.c $MUPDF_ROOT/source/html/html-layout.c
#cp -rp jni-1.11/~mupdf/xml.c $MUPDF_ROOT/source/fitz/xml.c
#cp -rp jni-1.11/~mupdf/stext-output.c $MUPDF_ROOT/source/fitz/stext-output.c
#cp -rp jni-1.11/~mupdf/mucbz.c $MUPDF_ROOT/source/cbz/mucbz.c
#
#cp -rp jni-1.11/~mupdf/structured-text.h $MUPDF_ROOT/include/mupdf/fitz/structured-text.h

cd $MUPDF_JAVA

ndk-build APP_BUILD_SCRIPT=$MUPDF_JAVA/Mobi/Android.mk APP_PROJECT_DIR=$MUPDF_JAVA APP_PLATFORM=android-16 APP_OPTIM=release APP_ABI=all

echo "MUPDF:" $MUPDF_JAVA
echo "LIBS:"  $LIBS