# 工作小结

* 增加有关andorid共享动画(又叫做转场动画)加载网络图片时遇到的卡顿的问题解决方案(如果是图片是local则不用如此麻烦)
这里加载图片用的是glide

* rectclerView出现java.lang.IndexOutOfBoundsException: Inconsistency detected. Invalid item position 2(offset:2)
    解决方案:原因就是在清除数据源的时候没有及时notify,需要及时更新list,否则就会报这个错误.
    
* rectclerView 的match_parent失效:
  解决方案:填充布局的方式改变一般有两种
  ```
  View.inflate(this,item);替换为LayoutInflater.from(parent.getContext()).inflate(item, parent, false);
  ```
* git 拉取代码出现The remote end hung up unexpectedly fatal: index-pack failed 错误的时候,一般是git的缓存出现了问题
解决方案:执行下面命令 git config http.postBuffer 524288000






