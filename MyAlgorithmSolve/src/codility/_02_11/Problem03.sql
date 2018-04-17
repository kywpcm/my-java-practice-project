-- noinspection SqlNoDataSourceInspectionForFile



create table events (
	event_type integer not null,
	value integer not null,
	time timestamp not null,
	unique(event_type, time)
);


INSERT INTO events (event_type,value,"time") VALUES (
2,5,2015-05-09 12:42:00);
INSERT INTO events (event_type,value,"time") VALUES (
4,-42,2015-05-09 13:19:57);
INSERT INTO events (event_type,value,"time") VALUES (
2,2,2015-05-09 14:48:30);
INSERT INTO events (event_type,value,"time") VALUES (
2,7,2015-05-09 12:54:39);
INSERT INTO events (event_type,value,"time") VALUES (
3,16,2015-05-09 13:19:57);
INSERT INTO events (event_type,value,"time") VALUES (
3,20,2015-05-09 15:01:09);


--------------------------------------------------------------------------------------------------


SELECT
		*
FROM (
	SELECT
			event_type
			, value
			, time
	FROM events T1
	WHERE
		 (SELECT COUNT(*)
		 	FROM events
		   WHERE event_type = T1.event_type
		     AND time >= T1.time) <= 2
      AND T1.event_type IN (SELECT event_type
         				   	  FROM (SELECT event_type
         								   , COUNT(event_type) AS CNT
         						      FROM events
         						  GROUP BY event_type)
         				     WHERE CNT > 1
         				   )
) A
ORDER BY event_type ASC, time DESC
;



















