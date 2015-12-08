# MuPDFDemo
##说明
本项目中MuPDF模块的采用[MuPDF Tag1.8](http://git.ghostscript.com/?p=mupdf.git;a=summary) 进行编译.  
##使用方式:
###Step1
1.在AS中将mupdf作为Lib Module导入  
2.修改app Module的build.gradle文件,添加如下依赖项
```
dependencies {
   ......
   ......
    compile project(':mupdf')
}
```
###Step2
复制如下信息至`Manifest`文件中
```
<activity
            android:name="com.artifex.mupdfdemo.MuPDFActivity"
            android:label="@string/app_name">
            <intent-filter>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.DEFAULT"/>
                <data android:mimeType="application/vnd.ms-xpsdocument"/>
                <data android:mimeType="application/xps"/>
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.DEFAULT"/>
                <data android:mimeType="application/pdf"/>
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.DEFAULT"/>
                <data android:mimeType="application/x-cbz"/>
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.DEFAULT"/>
                <data android:mimeType="application/epub+zip"/>
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.DEFAULT"/>
                <category android:name="android.intent.category.BROWSABLE"/>
                <data android:scheme="file"/>
                <data android:mimeType="*/*"/>
                <data android:pathPattern=".*\\.xps"/>
                <data android:host="*"/>
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.DEFAULT"/>
                <category android:name="android.intent.category.BROWSABLE"/>
                <data android:scheme="file"/>
                <data android:mimeType="*/*"/>
                <data android:pathPattern=".*\\.pdf"/>
                <data android:host="*"/>
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.DEFAULT"/>
                <category android:name="android.intent.category.BROWSABLE"/>
                <data android:scheme="file"/>
                <data android:mimeType="*/*"/>
                <data android:pathPattern=".*\\.cbz"/>
                <data android:host="*"/>
            </intent-filter>
            <intent-filter>
                <action android:name="android.intent.action.VIEW"/>
                <category android:name="android.intent.category.DEFAULT"/>
                <category android:name="android.intent.category.BROWSABLE"/>
                <data android:scheme="file"/>
                <data android:mimeType="*/*"/>
                <data android:pathPattern=".*\\.epub"/>
                <data android:host="*"/>
            </intent-filter>
        </activity>
```
