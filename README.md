Introduction
===
    豌豆荚极速清理应用清理测试demo,通过uiautomator实现

* demo

<a href="http://www.youtube.com/watch?feature=player_embedded&v=97yTBkCSOB8
" target="_blank"><img src="http://img.youtube.com/vi/97yTBkCSOB8/0.jpg" 
alt="uiautomator" width="240" height="180" border="10" /></a>

Android Studio创建测试项目教程
-------------

1. 创建一个Android项目:`File--->New--->New Project`,然后选择空的activity点finish 

2. 在app/build.gradle下加入如下代码:

* dependencies中
```gradle 
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:23.0.1'
    androidTestCompile 'com.android.support:support-annotations:23.0.1'
    androidTestCompile 'com.android.support.test:runner:0.4.1'
    androidTestCompile 'com.android.support.test.uiautomator:uiautomator-v18:2.1.1'
    // Set this dependency if you want to use Hamcrest matching
    androidTestCompile 'org.hamcrest:hamcrest-library:1.3'
    }
```
* defaultConfig中
```gradle
 defaultConfig {
        testInstrumentationRunner 'android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner'
        testHandleProfiling true
        testFunctionalTest true
    }
```

3.在app/androidTest/目录下添加测试类并编写测试方法,在测试方法前引入`@Test`关键字

4.编译运行:
  点击`Run--->edit configrations`,选中`Android Application`然后点击左上角`"+"`号,添加`Android Tests`,然后命名随意


:exclamation: (重要)设置Instrumentation runner为
```gradle
  android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner*
```
保证其和`defaultConfig`中的`testInstrumentationRunner`相同
> testInstrumentationRunner 'android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner'

5.连上手机查看用例输出效果

