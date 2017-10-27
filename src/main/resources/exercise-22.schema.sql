CREATE TABLE IF NOT EXISTS airplanes
(
  id                   INTEGER PRIMARY KEY,
  model_name           TEXT,
  seat_capacity        INTEGER,
  next_inspection_date TEXT,
  weight               INTEGER
);