### 作业要求

根据课堂上的demo，完成下面需求
1. 提供获取某一条热搜事件的接口
2. 提供能够根据起始参数，获取对应范围内的热搜事件列表的接口
3. 提供添加热搜事件的接口（事件包含两个字段：事件名称和关键字）
4. 提供修改某条热搜事件的接口（demo没有展示，请大家自己完成）
5. 提供删除某条热搜事件的接口（demo没有展示，请大家自己完成）

#### 需求4、5详细描述

* 需求4： 修改某条事件时（通过参数传递的序号，修改列表中对应的事件数据），如果RequestBody只传了eventName没有传keyword那么仅仅只修改eventName
         如果只传了keyword没有传eventName，那么只修改keyword字段
         如果两个字段都传了，那么都进行修改

* 需求5： 通过参数传递的序号，删除列表中对应的某条事件数据


<span style="color: red"> 注意：所有的需求都请先写测试再写实现 </span>


#### 实现如下接口
* 注册用户：参照demo，将注册用户持久化到数据库中(docker容器内启动的mysql数据库，并非内存数据库)
* 获取用户：新增获取用户接口，传递id返回对应id的用户数据
* 删除用户：新增删除用户接口，传递id从数据库中删除对应id用户数据

* 写测试！！！
