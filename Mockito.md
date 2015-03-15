
```
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
 
import static org.mockito.Mockito.*;
 
 
@RunWith(value = MockitoJUnitRunner.class)
public class MyTest {
 
      
       @Mock
       private MyExternalClass x;
 
 
       
        when(x.myFunction((MyParameterType) any())).thenReturn(Collections.<MyReturnType>emptySet());
 
also verify()
```

See also : RefCard in google documents