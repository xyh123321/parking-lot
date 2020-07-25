
**1 Given:**  parking boy, parking manager,managementList

**When:** manager add boy to list

**Then:**  true

---

**2 Given:**  parking boy, parking manager,car

**When:** manager specify  boy to park car

**Then:**  boy'name+ticket

---

**2-1 Given:**  parking boy(not in list), parking manager,car

**When:** manager specify  boy to park car

**Then:**  false

---

**3 Given:**  parking boy, parking manager,car

**When:** manager specify  boy to fetch car

**Then:**  boy'name+car

---

**4 Given:**  parking manager,car

**When:** manager park car

**Then:**  ticket

---

**5 Given:**  parking manager,car

**When:** manager fetch car

**Then:**  car

---

**6 Given:**  parking manager,car, parking boy, the ticket is  wrong

**When:** manager specify boy to fetch car

**Then:**  "Unrecognized parking ticket."

---
**7 Given:**  no ticket , parking manager,car, parking boy

**When:** manager specify boy to fetch car

**Then:**  "Please provide your parking ticket."

---
**8 Given:**  car ,parking manager,car, parking boy, no position lot

**When:** manager specify boy to park car

**Then:**  "Not enough position."