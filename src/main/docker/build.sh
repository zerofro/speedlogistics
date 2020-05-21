#!/bin/bash

# 停止容器
sudo docker stop speed-logistics

# sleep 2s

# 删除容器
sudo docker rm speed-logistics

# 删除镜像
sudo docker rmi speedlogistics:1.0

# 构建镜像 . 号表示在当前目录构建
sudo docker build -t speedlogistics:1.0 .

# 创建容器并启动
sudo docker run -d -p 8071:8071 --name speed-logistics speedlogistics:1.0
