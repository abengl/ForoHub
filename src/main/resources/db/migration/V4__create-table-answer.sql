CREATE TABLE IF NOT EXISTS answer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    reply_message VARCHAR(500) NOT NULL,
    topic_id BIGINT NOT NULL,
    creation_date DATETIME NOT NULL,
    author_id BIGINT NOT NULL,
    FOREIGN KEY (topic_id) REFERENCES topic(id) ON DELETE CASCADE,
    FOREIGN KEY (author_id) REFERENCES user_foro(id) ON DELETE CASCADE
);

