INSERT INTO project (name, customer, start_date, end_date, status) VALUES
                                                                       ('Alpha Website', 'Alpha Solutions', '2025-11-01', '2025-12-20', 'IN_PROGRESS'),
                                                                       ('Beta App', 'Beta Corp', '2025-10-10', NULL, 'ON_HOLD'),
                                                                       ('Internal Tool', 'Alpha Solutions', '2025-09-01', '2025-11-30', 'COMPLETED');

INSERT INTO task (name, description, status, project_id)
SELECT 'Database setup', 'Create schema and test data', 'COMPLETED', p.id
FROM project p WHERE p.name = 'Alpha Website';

INSERT INTO task (name, description, status, project_id)
SELECT 'Project CRUD', 'Create and edit projects', 'IN_PROGRESS', p.id
FROM project p WHERE p.name = 'Alpha Website';

INSERT INTO task (name, description, status, project_id)
SELECT 'Reporting', 'Generate project reports', 'NOT_STARTED', p.id
FROM project p WHERE p.name = 'Alpha Website';

INSERT INTO task (name, description, status, project_id)
SELECT 'Login system', 'Spring Security login', 'IN_PROGRESS', p.id
FROM project p WHERE p.name = 'Beta App';

INSERT INTO task (name, description, status, project_id)
SELECT 'Time registration', 'Register hours on tasks', 'NOT_STARTED', p.id
FROM project p WHERE p.name = 'Beta App';

INSERT INTO task (name, description, status, project_id)
SELECT 'Cleanup', 'Refactor and polish code', 'COMPLETED', p.id
FROM project p WHERE p.name = 'Internal Tool';

INSERT INTO time_entry (date, hours, description, task_id)
SELECT '2025-11-02', 2.5, 'Initial database design', t.id
FROM task t WHERE t.name = 'Database setup';

INSERT INTO time_entry (date, hours, description, task_id)
SELECT '2025-11-03', 1.5, 'Constraints and relations', t.id
FROM task t WHERE t.name = 'Database setup';

INSERT INTO time_entry (date, hours, description, task_id)
SELECT '2025-11-10', 3.0, 'Project controller', t.id
FROM task t WHERE t.name = 'Project CRUD';

INSERT INTO time_entry (date, hours, description, task_id)
SELECT '2025-11-11', 2.0, 'Thymeleaf forms', t.id
FROM task t WHERE t.name = 'Project CRUD';

INSERT INTO roles (name) VALUES
                             ('ADMIN'),
                             ('USER');

INSERT INTO users (username, password) VALUES
    ('admin', '$2a$10$DOWSDYlZ4kTnZtIuQy8KkO6lGxQd3Vw2xG3mZc1J4m0Yd3gHk8G0a');

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id
FROM users u, roles r
WHERE u.username = 'admin'
  AND r.name = 'ADMIN';
