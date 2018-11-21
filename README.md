# 轻量级的log打印工具
## 添加依赖：

### Project中的build.gradle中添加：

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
### app中的build.gradle中添加：

```
dependencies {
    implementation 'com.github.cuitie88:GentlyLog:v1.0.1'
}
```

## 使用方法

### 初始化

```
  GLog.isLog(true);//设置是否显示打印
  GLog.setTag("GGG");//设置打印Tag
```

### 使用

```
        //打印string
        GLog.log.d(msg);
        GLog.log.i(msg);
        GLog.log.e(msg);
        GLog.log.d(tag,msg);
        GLog.log.i(tag,msg);
        GLog.log.e(tag,msg);

        //打印json
        GLog.log.j(json);
        GLog.log.j(tag,json);

        //打印xml
        GLog.log.x(xml);
        GLog.log.x(tag,xml);
        
```
