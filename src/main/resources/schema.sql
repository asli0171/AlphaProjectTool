DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS time_entry;
DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS project;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE project (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         name VARCHAR(100) NOT NULL,
                         customer VARCHAR(100) NOT NULL,
                         start_date DATE NOT NULL,
                         end_date DATE NULL,
                         status VARCHAR(30) NOT NULL,
                         PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE task (
                      id BIGINT NOT NULL AUTO_INCREMENT,
                      name VARCHAR(100) NOT NULL,
                      description VARCHAR(500),
                      status VARCHAR(30) NOT NULL,
                      project_id BIGINT NOT NULL,
                      PRIMARY KEY (id),
                      CONSTRAINT fk_task_project
                          FOREIGN KEY (project_id)
                              REFERENCES project(id)
                              ON DELETE CASCADE
                              ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE time_entry (
                            id BIGINT NOT NULL AUTO_INCREMENT,
                            date DATE NOT NULL,
                            hours DECIMAL(5,2) NOT NULL,
                            description VARCHAR(500),
                            task_id BIGINT NOT NULL,
                            PRIMARY KEY (id),
                            CONSTRAINT fk_time_entry_task
                                FOREIGN KEY (task_id)
                                    REFERENCES task(id)
                                    ON DELETE CASCADE
                                    ON UPDATE CASCADE,
                            CONSTRAINT chk_time_entry_hours_positive
                                CHECK (hours > 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE roles (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       name VARCHAR(50) NOT NULL,
                       PRIMARY KEY (id),
                       UNIQUE (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE users (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       PRIMARY KEY (id),
                       UNIQUE (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE user_roles (
                            user_id BIGINT NOT NULL,
                            role_id BIGINT NOT NULL,
                            PRIMARY KEY (user_id, role_id),
                            CONSTRAINT fk_user_roles_user
                                FOREIGN KEY (user_id)
                                    REFERENCES users(id)
                                    ON DELETE CASCADE
                                    ON UPDATE CASCADE,
                            CONSTRAINT fk_user_roles_role
                                FOREIGN KEY (role_id)
                                    REFERENCES roles(id)
                                    ON DELETE CASCADE
                                    ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
