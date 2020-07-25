
**1 Given:**  car , parking boy

**When:** parking boy park car

**Then:** ticket

---
**2 Given:**  ticket , parking boy , 1 car in parking lot

**When:** parking boy fetch the car

**Then:** correct car

---
**3 Given:**  parking boy , 2 cars

**When:** parking boy parking 2 car

**Then:** 2 tickets

---
**4 Given:**  2 tickets , parking boy , 2 cars in parking lot

**When:** parking boy fetch 2 cars

**Then:** correct car

---
**5 Given:**  wrong ticket , parking boy

**When:** parking boy fetch car

**Then:** no car: the ticket is wrong.

---
**6 Given:**  used ticket , parking boy

**When:** parking boy fetch car

**Then:** no car: The ticket has already been used

---
**7 Given:**  car , parking boy, parking lot

**When:** parking boy parking  car

**Then:** no position tips
