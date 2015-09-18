USE `rally_inspector`;

CREATE TABLE `discrepancy_type` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL DEFAULT '0',
	`description` VARCHAR(100) NOT NULL DEFAULT '0',
	`target_audience` VARCHAR(100) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1
;

CREATE TABLE `discrepancy_report` (
	`id` INT(20) NOT NULL AUTO_INCREMENT,
	`disc_type_id` INT(20) NOT NULL DEFAULT '0',
	`formatted_id` VARCHAR(100) NOT NULL DEFAULT '0',
	`artifact_name` VARCHAR(100) NOT NULL DEFAULT '',
	`artifact_ref` VARCHAR(100) NOT NULL DEFAULT '',
	`team_name` VARCHAR(100) NULL DEFAULT '',
	`artifat_owner` VARCHAR(100) NULL DEFAULT '',
	`product_owner` VARCHAR(100) NULL DEFAULT '',
	`created_date` DATE NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `disc_type_id` (`disc_type_id`),
	CONSTRAINT `discrepancy_report_ibfk_1` FOREIGN KEY (`disc_type_id`) REFERENCES `discrepancy_type` (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=123
;


CREATE TRIGGER `discrepancy_report_before_insert` BEFORE INSERT ON `discrepancy_report` FOR EACH ROW BEGIN
if (isnull(new.created_date) ) then
 set new.created_date = curdate();
end if;
END;



