# BlockReminder

<img src="BlockReminder.png" width="300" height="300" alt="image">

## 插件功能

放置或者挖掘一个方块，就会给他发送一条消息


## 插件信息

已测试版本：   1.20.1

服务端： Spigot、Paper


## 插件使用

直接在配置文件中增添配置项，重启服务端后插件配置生效



## 插件权限

**绕过监听事件的权限**

**权限：**`BlockReminder.bypass.<组名>`

**例如：**拥有 BlockReminder.bypass.test1 这个权限的玩家，那么他绕过这个组的行为管控


### 五、配置文件

config.yml

```yaml
test1:
  #放置的方块
  material: ancient_debris
  #发送给该玩家的信息
  message: '§e恭喜你挖到1个远古残骸'
  #隔了多少秒后，如果继续放置该方块的话，则再次给该玩家发送message
  #（以防放置一个方块就提醒一次）
  #（如果设置为0，则为放置一个该方块就提醒一次）
  delay: 0
  #是否撤回此次事件 （挖掘 / 放置）
  revocate: false
  #启用该配置的世界
  worlds: world_nether
  #监听什么的事件：放置 / 挖掘
  behavior: destroy
test2:
  material: soul_sand
  message: '§c请不要在主世界制造凋零哦'
  delay: 10
  revocate: true
  worlds: world
  behavior: place
test3:
  material: beacon
  message: '§e恭喜你制造出了1个信标'
  delay: 0
  revocate: false
  worlds: world,world_nether,world_end
  behavior: place


```

material：放置的方块

message：发送给该玩家的信息

delay：隔了多少秒后，如果继续放置该方块的话，则再次给该玩家发送message（如果设置为0，则为放置一个该方块就提醒一次）

revocate：是否撤回此次事件 （挖掘 / 放置）

worlds：启用该配置的世界

behaviour：放置 / 挖掘
