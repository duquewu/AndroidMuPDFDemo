# MuPDFDemo
##说明
本项目中MuPDF模块的采用[MuPDF Tag1.8](http://git.ghostscript.com/?p=mupdf.git;a=summary) 进行编译.  
##使用方式:
1.在AS中将mupdf作为Lib Module导入  
2.修改app Module的build.gradle文件,添加如下依赖项
```
dependencies {
   ......
   ......
    compile project(':mupdf')
}
```

