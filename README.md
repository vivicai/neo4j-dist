# Neo4jDB HA Implementation
This project is trying to implement HA on Neo4j community.</br> 
- - -
# 1. Requirement
1. Java Version 1.8
2. Scala Version **MUST BE** 2.11.0
- - -
# 2. How to run
1. Set your neo4j database's account and password and set your Zookeeper connectString and sessionTimeout In "MySettings.scala".
2. Start your Neo4j server in every node.
3. Start your Zookeeper server in every node.

4. run the "ZkServer.java" in every node.
5. run the "Coordinator.scala" in every node.

Then you can watch main/scala/test's 2 file, change 'client.scala' line24's code  to ReadCypher/WriteCypher and change 'RunClient.scala' according to your needs. and see the result from RpcClient console and cluster's http://localhost:7474/browser/.
