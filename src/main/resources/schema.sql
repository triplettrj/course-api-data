CREATE TABLE topics (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE courses (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    topic_id VARCHAR(255),
    FOREIGN KEY (topic_id) REFERENCES topics(id)
);
