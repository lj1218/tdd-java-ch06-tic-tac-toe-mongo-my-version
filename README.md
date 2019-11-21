# tdd-java-ch06-tic-tac-toe-mongo-my-version

Reference: [https://bitbucket.org/vfarcic/tdd-java-ch06-tic-tac-toe-mongo.git](https://bitbucket.org/vfarcic/tdd-java-ch06-tic-tac-toe-mongo.git)

## 测试步骤

+ 启动 `MongoDB`

```bash
./run_mongoDB.sh
```

+ 启动测试

```bash
gradle clean test
```

+ 关闭 `MongoDB`

```bash
docker rm -f mongoDB >/dev/null 2>&1
```
