## ***Spring boot - PULSAR EXCAMEPLE*** ##

Introducing Spring for Apache Pulsar  
ref: https://www.youtube.com/watch?v=94Grr5IAIyk
Spring 공식 유튜브 펄사 소개  

영상에선 네이티브 클라우드의 메세징, 스트리밍앱 분산처리의 한종류로써  
kafka, rabbitmq, activemq등과 비슷한걸로 소개하고있습니다.  
Queue의 추상화작업 큐 의미론을 갖고있다.  

Pulsar: 
Message log  
multitenancy https://www.redhat.com/ko/topics/cloud-computing/what-is-multitenancy  
무국적 중개개념:  
  kafka  
   broker state storage save   
   1broker 1unit storage(10만개정도) 브로커와스토리지가 함께있어 무한이 증가 할수 없다  
  pulsar  
   stateful, stateless 둘다 할수있다. / bokie, bookkeeper를 사용하여(무한히 확장)  

브로커 확장이 kafka보다 쉽다.   
이부분이 Pulsar의 포인트라고 한다.

Spring은 Pulsar가 Spring 친화적으로 제공되어야하기때문에 프로젝트를 만들었다고합니다.  

Pub-Sub 패턴에 속한다.  
Pulsar Pattern = Pub-Sub  
Message  
Topic   
Subscription  
Publisher  
Subscriber  

Kafka는 파티션으로 나누지만 Pulsar는 메세지 토픽등으로 분리한다.  
![img.png](src%2Fmain%2Fresources%2Freadmeimg%2Fimg.png)  
펄사는 구독자가 한명만 있어도 된다.  
개별구조에서 장애조치를 할 수 있다.  
다양한 유형의 사용자를 허용 할 수 있다.  

단순화한 Pulsar 사용 아키 예제  
![img_1.png](src%2Fmain%2Fresources%2Freadmeimg%2Fimg_1.png)
Pulsar Client API는 여러 언어의 바인딩을 한다.  
Spring Dev는 Pulsar Client API 에 JavaClient 를 추가 한다 
![img_2.png](src%2Fmain%2Fresources%2Freadmeimg%2Fimg_2.png)
Spring Pulsar는 이 그림대로 yml을 통해 펄사 설정을 할 수 있게 만들었다.  
다른 mq들과 동일하게 템플릿과 메세지로 컨트롤 할 수 있게 만들었다.  

Pulsar는 PulsarIO 로 외부에서 받을수도있다.  
Pulsar Function은 아직 기능이 제한되어있다.  
에러 핸들링시 마지막 데이터조각을 빼고 소비자에게서 받을 수 있다.  
펄사는 유연한 Pulsar ReaderAPI를 지원한다. (자동 스키마 주제감지를 자동으로)  
kafka처럼 avro 직렬 변환기를 사용 할 수 있다.  
Spring cloud Stream Pulsar Binder 를 별도로 만들었다.  
GaalVM 에서 Native img를 지원한다.  
Micrometer 모니터링 기능을 펄사와 연결 할 수 있다. 
해당 영상의 git demo https://github.com/onobc/intro-spring-pulsar-demo  


향후 해볼 Exame  
https://github.com/onobc/intro-spring-pulsar-demo  
https://github.com/majusko/pulsar-java-spring-boot-starter  

