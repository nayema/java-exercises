CREATE SCHEMA IF NOT EXISTS "exercise-22";

SET search_path TO "exercise-22";

CREATE TABLE IF NOT EXISTS airplanes
(
  id                   SERIAL PRIMARY KEY,
  model_name           TEXT,
  seat_capacity        INTEGER,
  next_inspection_date TEXT,
  weight               INTEGER
);