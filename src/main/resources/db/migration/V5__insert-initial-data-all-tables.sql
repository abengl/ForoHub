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
    ('DevOps pipeline setup', 'Looking for advice on setting up CI/CD pipelines.', NOW(), 'CLOSED', 3, 3),
    ('Most used frontend resources', 'Let\'s discuss the most used frontend resources to learn from scratch.',
     DATE_SUB(NOW(), INTERVAL 7 DAY), 'ONGOING', 1, 1),
    ('Backend frameworks', 'Which web framework to learn for backend?', DATE_SUB(NOW(), INTERVAL 1 DAY), 'ONGOING',
     2, 2),
    ('DevOps certification', 'Looking for advice on recommendations for beginners.', DATE_ADD(NOW(), INTERVAL 1 DAY),
     'ONGOING', 3, 3),
    ('Frontend testing tools', 'What are the most reliable tools for testing frontend applications?',
     DATE_ADD(NOW(), INTERVAL 3 DAY), 'OPEN', 1, 1),
    ('Database optimization', 'Best practices for optimizing SQL queries.', DATE_SUB(NOW(), INTERVAL 2 DAY), 'ONGOING', 2, 2),
    ('Cloud deployment challenges', 'Common issues when deploying applications to cloud platforms.',
     DATE_ADD(NOW(), INTERVAL 4 DAY), 'OPEN', 3, 3),
    ('Learning GitHub Actions', 'How to start using GitHub Actions for CI/CD workflows?', DATE_SUB(NOW(), INTERVAL 6 DAY), 'CLOSED', 1, 1);

-- Populate `answer` table
INSERT INTO answer (reply_message, topic_id, creation_date, author_id)
VALUES
    ('I think React is the best framework.', 1, NOW(), 3),
    ('You can try caching to optimize performance.', 2, NOW(), 1),
    ('Use Jenkins and Docker for CI/CD.', 3, NOW(), 2),
    ('I recommend roadmap.sh to have review where to start and build up your learning journey.', 4, DATE_SUB(NOW(),
    INTERVAL 3 DAY), 3),
    ('Spring boot is a great alternative for Java.', 5, DATE_SUB(NOW(), INTERVAL 5 HOUR), 1),
    ('Azure Fundamentals is a good option to start.', 6, DATE_ADD(NOW(), INTERVAL 2 DAY), 2),
    ('Cypress is a great tool for frontend testing.', 7, DATE_SUB(NOW(), INTERVAL 1 DAY), 3),
    ('Use EXPLAIN to analyze SQL queries.', 8, DATE_SUB(NOW(), INTERVAL 4 DAY), 1),
    ('Check the logs carefully when facing cloud deployment issues.', 9, DATE_ADD(NOW(), INTERVAL 5 DAY), 2),
    ('GitHub Actions has great documentation for beginners.', 10, DATE_SUB(NOW(), INTERVAL 6 DAY), 3);