import { Suspense } from 'react';
import React  from 'react'
const Component3 = React.lazy(() => import ('../f1/C3'));
const Component4 = React.lazy(() => import('../../f2/C4'));
import C5 from '../../f2/C5'
export default function C2() {
  return (
   <>
   <h2>C2 Component!</h2>

     <Suspense fallback={<h1>Loading Component 3...</h1>}>
     <Component3/>
    
     </Suspense>
     <Suspense fallback={<h1>Loading Component 4...</h1>}>
     <h2><Component4/></h2>
    
     </Suspense>

    
    <h2><C5/></h2>
    </>
   
  );
  
}
