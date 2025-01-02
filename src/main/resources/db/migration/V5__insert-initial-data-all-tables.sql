USE forohub;

-- Populate `course` table
INSERT INTO course (name, category)
VALUES
    ('Frontend Basics', 'FRONTEND'),
    ('Backend Essentials', 'BACKEND'),
    ('DevOps Practices', 'DEVOPS');

-- Populate `user_foro` table
INSERT INTO user_foro (name, email, password, role)
VALUES
    ('Ana Rojas', 'arojas@mail.com', '$2a$12$va082uzR19yvuL5dFJz/4efrcuRrDpJbxRcTVLNbLolqrU9jF0OOK', 'ADMIN'),
    ('Mateo Perez', 'mperez@mail.com', '$2a$12$va082uzR19yvuL5dFJz/4efrcuRrDpJbxRcTVLNbLolqrU9jF0OOK', 'MODERATOR'),
    ('Sofia Gomez', 'sgomez@mail.com', '$2a$12$va082uzR19yvuL5dFJz/4efrcuRrDpJbxRcTVLNbLolqrU9jF0OOK', 'USER');

-- Populate `topic` table
INSERT INTO topic (title, message, creation_date, status, author_id, course_id)
VALUES
    ('What is the best frontend framework?', 'Let\'s discuss the best tools for frontend development.', NOW(), 'OPEN', 1, 1),
    ('Backend optimization tips', 'How can I optimize my backend application?', NOW(), 'ONGOING', 2, 2),
    ('DevOps pipeline setup', 'Looking for advice on setting up CI/CD pipelines.', NOW(), 'CLOSED', 3, 3);

-- Populate `answer` table
INSERT INTO answer (reply_message, topic_id, creation_date, author_id)
VALUES
    ('I think React is the best framework.', 1, NOW(), 3),
    ('You can try caching to optimize performance.', 2, NOW(), 1),
    ('Use Jenkins and Docker for CI/CD.', 3, NOW(), 2);
