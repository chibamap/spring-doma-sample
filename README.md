# Spring Doma Sample



# Run

- run app
```$xslt
docker-compose up -d
gradle bootRun
```


# sample api

### Pick up piyo group people.

pick up 'person' record by group name

```$xslt
curl http://localhost:8080/demo/test?groupName=piyo
```


### rollback check

Register 10 valid record into person, then fail to add illegal group_id record.
All 10 valid record will be rollback.

```$xslt
curl http://localhost:8080/demo/rollback
```

### commit work


```$xslt
curl http://localhost:8080/demo/commit?
```

### CRUD


- get

```
curl http://localhost:8080/person/2
```

- create

```
curl -X POST http://localhost:8080/person \
-H 'Content-type: application/json' \
-d '{ "firstName": "user", "lastName": "rest"} '
```


- update

```
curl -X PUT http://localhost:8080/person \
-H 'Content-type: application/json' \
-d '{ "id":"3", "firstName": "guy", "lastName": "updated"} '
```

- delete

```$xslt
curl -X DELETE http://localhost:8080/person/62
```

### Validation

- on-Request (Spring standard like struts)

```$xslt
curl -X POST http://localhost:8080/validate/request \
 -H 'Content-type: application/json' \
 -d '{ "firstName":"hoge","lastName": "rest", "groupId": 2} ' | jq .
```


