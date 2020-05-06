# Springboot + MongoDB Test Page

# http://localhost:8088/

<pre>
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
**:: Spring Boot ::       (v2.2.4.RELEASE)**


$mongo
> show dbs
admin             0.000GB
config            0.000GB
local             0.000GB
mongodb_tutorial  0.000GB
test              0.000GB
web               0.000GB
> use admin
> db.createUser(
  {
    user: "mongodb_exporter",
    pwd: "password",
    roles: [
        { role: "clusterMonitor", db: "admin" },
        { role: "read", db: "local" }
    ]
  }
)
> db.getUsers( )
[
        {
                "_id" : "admin.mongodb_exporter",
                "userId" : UUID("8e0c4460-bfac-42cd-abf4-e14e2fb1ed37"),
                "user" : "mongodb_exporter",
                "db" : "admin",
                "roles" : [
                        {
                                "role" : "clusterMonitor",
                                "db" : "admin"
                        },
                        {
                                "role" : "read",
                                "db" : "local"
                        }
                ],
                "mechanisms" : [
                        "SCRAM-SHA-1",
                        "SCRAM-SHA-256"
                ]
        }
]
> db.runCommand( { serverStatus: 1 } )
> db.runCommand( { serverStatus: 1, repl : 0, metrics: 0, locks: 0 } )
> db.runCommand( { serverStatus: 1, repl : 1 } )
> use web
switched to db web
> db
web
> db.createUser({user: "web", pwd: "web", roles:["readWrite"])
> db.getUsers( )
[
        {
                "_id" : "web.web",
                "userId" : UUID("2f682af1-22f4-4f20-9acc-92659774d1ff"),
                "user" : "web",
                "db" : "web",
                "roles" : [
                        {
                                "role" : "readWrite",
                                "db" : "web"
                        }
                ],
                "mechanisms" : [
                        "SCRAM-SHA-1",
                        "SCRAM-SHA-256"
                ]
        }
]
> show collections
customer
guestbook
member
memo
> db.memo.count( )
5
> db.memo.find( )
{ "_id" : ObjectId("5e30d089d3c248783a95f2f3"), "writer" : "Seo", "memo" : "서태열의 메모", "post_date" : ISODate("2020-01-29T00:23:37.143Z"), "_class" : "com.example.mongo.model.memo.dto.MemoDTO" }
{ "_id" : ObjectId("5e30d0acd3c248783a95f2f4"), "writer" : "서태열", "memo" : "바른 메모", "post_date" : ISODate("2020-01-29T00:24:12.676Z"), "_class" : "com.example.mongo.model.memo.dto.MemoDTO" }
{ "_id" : ObjectId("5e310e3ba788a050bb546ee4"), "writer" : "서태열", "memo" : "한줄 메모장 테스트", "post_date" : ISODate("2020-01-29T04:46:51.009Z"), "_class" : "com.example.mongo.model.memo.dto.MemoDTO" }
{ "_id" : ObjectId("5e312059a788a050bb546efb"), "writer" : "서태열", "memo" : "한줄 메모 테스트 22222", "post_date" : ISODate("2020-01-29T06:04:09.485Z"), "_class" : "com.example.mongo.model.memo.dto.MemoDTO" }
{ "_id" : null, "memo" : "한줄 메모 테스트 22222 - 수정 테스트 1", "writer" : "서태열" }
> db.memo.count( );
5
> db.people.insert({"name" : "한글" })
> db.people.insert({"name" : "ENG", desc : "mongodb 테스트" })
> db.people.find({})
> db.people.find({ name: "한글" })
> db.people.remove({ name: "한글" })
> 
> db.people.drop( )
> db.dropDatabase( )
> db.adminCommand( { shutdown: 1 } )
> exit
</pre>






# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [MongoDB](https://www.mongodb.com/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
