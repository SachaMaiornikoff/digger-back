# Sacha Maiornikoff

## SQL database creation

    CREATE USER 'xxx'@'%' IDENTIFIED BY  '***';
    GRANT USAGE ON * . * TO  'xxx'@'%' IDENTIFIED BY  '***' WITH MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0 ;
	CREATE DATABASE IF NOT EXISTS  `perso-digger` ;
	GRANT ALL PRIVILEGES ON  `perso-digger` . * TO  'xxx'@'%';
	CREATE TABLE `user` (
      `id` int(11) NOT NULL,
      `password` varchar(32) NOT NULL,
      `privileges` int(11) NOT NULL,
      `description` text NOT NULL,
      `email` varchar(100) DEFAULT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

## ElasticSearch

Just have an ElasticSearch instance running on localhost:9300, the app will create the index.

## Front

Front project coming soon on another repo (will upload URL when it's up)

## Back

Just run BackApplication to start the back. Postman collections to test it comming soon.