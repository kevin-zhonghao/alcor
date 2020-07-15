#!/bin/bash

# Install prerequisites
if [[ "$OSTYPE" == "linux-gnu" ]]; then

  echo "delete yaml files"

  kubectl delete services ignite-alcor-service
  kubectl delete deployment ignite-alcor

  kubectl delete configmap sg-configmap
  kubectl delete services sgmanager-service
  kubectl delete deployment sgmanager

  kubectl delete configmap vpc-configmap
  kubectl delete services vpcmanager-service
  kubectl delete deployment vpcmanager

  kubectl delete configmap subnet-configmap
  kubectl delete services subnetmanager-service
  kubectl delete deployment subnetmanager

  kubectl delete configmap route-configmap
  kubectl delete services routemanager-service
  kubectl delete deployment routemanager

  kubectl delete configmap mac-configmap
  kubectl delete services macmanager-service
  kubectl delete deployment macmanager

  kubectl delete configmap ip-configmap
  kubectl delete services ipmanager-service
  kubectl delete deployment ipmanager

  kubectl delete configmap port-configmap
  kubectl delete services portmanager-service
  kubectl delete deployment portmanager

  kubectl delete configmap node-configmap
  kubectl delete services nodemanager-service
  kubectl delete deployment nodemanager

  kubectl delete configmap api-configmap
  kubectl delete services apimanager-service
  kubectl delete deployment apimanager

  kubectl delete configmap dpm-configmap
  kubectl delete services dpmmanager-service
  kubectl delete deployment dpmmanager


elif [[ "$OSTYPE" == "darwin"* ]]; then
  echo "Install prerequisites in Mac OSX"
  /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
  brew install maven

#  echo "Clean build legacy controller project"
#  mvn clean
#  mvn compile
#  mvn install -DskipTests

  echo "Clean build common library project"
  cd lib
  mvn clean
  mvn compile
  mvn install -DskipTests
  cd ..

  echo "Clean build web project"
  cd web
  mvn clean
  mvn compile
  mvn install -DskipTests
  cd ..

  echo "Build service one by one under services directory"
  cd services
  for d in ./*/;
  do
      echo "Build service -  $d"
      cd $d
      mvn clean
      mvn compile
      mvn install -DskipTests
      cd ..
      echo "Build service -  $d completed"
  done

elif [[ "$OSTYPE" == "cygwin" ]]; then
  # POSIX compatibility layer and Linux environment emulation for Windows
  echo "Install prerequisites in Linux environment of Windows"
elif [[ "$OSTYPE" == "msys" ]]; then
  # Lightweight shell and GNU utilities compiled for Windows (part of MinGW)
  echo "Install prerequisites in MinGW of Windows"
else
  echo "Unknown supported OS"
fi

echo "Build completed"
