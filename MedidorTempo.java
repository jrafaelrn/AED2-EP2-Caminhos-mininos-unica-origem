import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;


public class MedidorTempo {	

 	private long inicio, inicioCpu;
	 
	
	public void comeca() {
		inicio = System.currentTimeMillis();
	}
	
	public long termina() {
		return (System.currentTimeMillis() - inicio);
	}


	public void comecaCpuTime( ) {
		ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
		inicioCpu = bean.isCurrentThreadCpuTimeSupported( ) ? bean.getCurrentThreadCpuTime() : 0L;
	}

  public long terminaCpuTime( ) {
    ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
    return bean.isCurrentThreadCpuTimeSupported( ) ? (bean.getCurrentThreadCpuTime() - inicioCpu)/1000000 : 0L;
  }

}