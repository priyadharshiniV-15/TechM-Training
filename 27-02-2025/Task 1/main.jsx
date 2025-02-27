import { createRoot } from "react-dom/client";
import Component1 from './Component/Component1.jsx';
import Component2 from './Component/Component2.jsx';
import Component3 from './Component/Component3.jsx';
import Component4 from './Component/Component4.jsx';
import Component5 from './Component/Component5.jsx';
createRoot(document.getElementById("root")).render(
  <>
  <h1 >Student Details</h1>
  <Component1 name="Priya"/>
  <Component2 age="21"/>
  <Component3 dept="ECE"/>
  <Component4 Phno="9363551627"/>
  <Component5 email="dharshiniragavan15@gmail.com"/>

  </>
);  
