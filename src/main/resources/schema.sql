CREATE TABLE IF NOT EXISTS Room (
    id INT PRIMARY KEY AUTO_INCREMENT,
    room_id uuid NOT NULL UNIQUE,
    creator_id uuid NOT NULL,
    creator_piece char NOT NULL 
);
