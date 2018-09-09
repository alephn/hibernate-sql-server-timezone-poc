# hibernate-sql-server-timezone-poc
Hibernate storing timezone in SQL Server POC

This POC is about persisting an entity with ZonedDateTime into SQL Server table with a datetimeoffset field. Through research I've found that if we store a properly formatted String (ISO-8601) SQL Server will convert it to datetimeoffset.
It would be better to use AttributeConverter from JPA 2.1. However current project constrains prevent that. (JPA 2.0 - Hibernate 4.1.9)
