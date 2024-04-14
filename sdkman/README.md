### SDKMAN ###  
SDK Version 관리 툴  
ref: https://sdkman.io/install   

```bash
curl -s "https://get.sdkman.io" | bash
```  
![1.png](image%2F1.png)  
```bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```  
```bash
sdk version
```   
![2.png](image%2F2.png)  
```bash
sdk install 
```     
Tab눌러서 받을 수 있는 버전 확인    
![3.png](image%2F3.png)  
```bash
sdk use java {{version}}
```  
![4.png](image%2F4.png)  
터미널을 다시켜야 적용된걸 확인 할 수 있다.