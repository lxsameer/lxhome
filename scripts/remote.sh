#! /bin/bash

echo "[REMOTE]: Cleaning up..."
rm -rf ~/resources
echo "[REMOTE]: Extracting the package..."
tar zxf ~/tmp/package.tar.gz
echo "[REMOTE]: Installing the content..."
mkdir -p ~/lxsameer.com
cp -rv ~/resources/public/ ~/lxsameer.com/home/
chmod 755 ~/lxsameer.com/home/ -R
echo "[REMOTE]: Cleaning up..."
rm -rf ~/resources ~/tmp/
mkdir -p ~/tmp
echo "[REMOTE]: Done"
