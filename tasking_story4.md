
**1 Given:**  car , SMART PARKING BOY,2 parking lots with different seats

**When:** smart parking boy parking  car

**Then:**  lot2:ticket

---
**2 Given:**  wrong ticket , SMART PARKING BOY,2 parking lots with different seats

**When:** smart parking boy fetch  car

**Then:**  "Unrecognized parking ticket."

---
**3 Given:**  no ticket , SMART PARKING BOY

**When:** smart parking boy fetch  car

**Then:**  "Please provide your parking ticket."

---
**4 Given:**  car , SMART PARKING BOY, no position 2lots

**When:** smart parking boy park car

**Then:**  Not enough position."