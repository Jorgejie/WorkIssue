# 工作小结

* 增加有关andorid共享动画(又叫做转场动画)加载网络图片时遇到的卡顿的问题解决方案(如果是图片是local则不用如此麻烦)
这里加载图片用的是glide

* rectclerView出现java.lang.IndexOutOfBoundsException: Inconsistency detected. Invalid item position 2(offset:2)
    解决方案:原因就是在清除数据源的时候没有及时notify,需要及时更新list,否则就会报这个错误.
    
* rectclerView 的match_parent失效:
  解决方案:填充布局的方式改变一般有两种
  ```
  View.inflate(this,item);--->LayoutInflater.from(parent.getContext()).inflate(item, parent, false);
  ```
  但是条能使用第二种此时在andorid5.0的手机上会出现一个问题就是item中的文字显示不全的情况,此种情况复现需要特殊的场景(就是条目显示的字数不同的情况下但是并不是多type的形式)
  而且使用第一种的时候相对布局的居左和居右是有效的,但是居中总是无效,但是线性布局是起作用的(原因暂时不明)
* git 拉取代码出现The remote end hung up unexpectedly fatal: index-pack failed 错误的时候,一般是git的缓存出现了问题
解决方案:执行下面命令 git config http.postBuffer 524288000

* andorid studio 更新到3.0之后 遇到这个问题Error:Unable to load class 'org.gradle.api.internal.component.Usage'.
解决方案是在根目录下加上        classpath 'com.novoda:bintray-release:0.5.0'

* 阿里云上传oss遇到stream closed,根本原因未找到,不过倒是可以利用andorid studio升级到3.0版本实现,现在只是发现在我的项目中使用会出现这个问题
之前的studio版本是2.3.2,升级之后不再出现. 后面在上线的时候,在打release包准备上线的时候,发现原先的问题就又在次出现,经过查看阿里云的log日志发现
造成这个问题的原因是和bugtags的网络上传有冲突,问了bugtags的客服后将build里关于bugtags的配置改成
   ```
    bugtags {
    mappingUploadEnabled false
    trackingNetworkEnabled true
    trackingNetworkExcludePackages 'com.alibaba.sdk.android.oss'
    }
   ```
   这里应该是将有关bugtags的全局监控的上传模块关闭掉对阿里云的监控.   这个问题是目前碰到的最难解决的问题没有之一,只能一点点的排查

*andorid 控件透明度改变注意事项:1,(例如imageView) 对iv设置背景色时要直接用#ffffff形式,不要直接饮用资源idcolor,如果引用的的话所有的引用这个id的控件透明度都会发生改变
如果直接是有iv.getBackground().setAlpha(int),这样的话在某些手机上会失效(比如我的z17),正确的姿势是iv.getBackground().mutate().setAlpha(int).








