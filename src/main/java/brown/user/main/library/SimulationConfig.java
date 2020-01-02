package brown.user.main.library;

import java.util.List;

import brown.user.main.IEndowmentConfig;
import brown.user.main.IGameConfig;
import brown.user.main.ISimulationConfig;
import brown.user.main.IValuationConfig;

public class SimulationConfig implements ISimulationConfig {

  private Integer simulationRuns;
  private List<IValuationConfig> vConfig;

  private List<IEndowmentConfig> eConfig;
  private List<List<IGameConfig>> mConfig;

  public SimulationConfig(Integer simulationRuns,
      List<IValuationConfig> vConfig, List<IEndowmentConfig> eConfig,
      List<List<IGameConfig>> mConfig) {

    this.simulationRuns = simulationRuns;
    this.eConfig = eConfig;
    this.mConfig = mConfig;
    this.vConfig = vConfig;
  }

  @Override
  public Integer getSimulationRuns() {

    return this.simulationRuns;
  }

  @Override
  public List<IValuationConfig> getVConfig() {

    return this.vConfig;
  }

  @Override
  public List<IEndowmentConfig> getEConfig() {

    return this.eConfig;
  }

  @Override
  public List<List<IGameConfig>> getMConfig() {

    return this.mConfig;
  }

  @Override
  public String toString() {
    return "SimulationConfig [simulationRuns=" + simulationRuns + ", vConfig="
        + vConfig + ", eConfig=" + eConfig + ", mConfig=" + mConfig + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((eConfig == null) ? 0 : eConfig.hashCode());
    result = prime * result + ((mConfig == null) ? 0 : mConfig.hashCode());
    result = prime * result
        + ((simulationRuns == null) ? 0 : simulationRuns.hashCode());
    result = prime * result + ((vConfig == null) ? 0 : vConfig.hashCode());
    return result;
  }

  @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      SimulationConfig other = (SimulationConfig) obj;
      if (eConfig == null) {
        if (other.eConfig != null)
          return false;
      } else if (!eConfig.equals(other.eConfig))
        return false;
      if (mConfig == null) {
        if (other.mConfig != null)
          return false;
      } else if (!mConfig.equals(other.mConfig))
        return false;
      if (simulationRuns == null) {
        if (other.simulationRuns != null)
          return false;
      } else if (!simulationRuns.equals(other.simulationRuns))
        return false;
      if (vConfig == null) {
        if (other.vConfig != null)
          return false;
      } else if (!vConfig.equals(other.vConfig))
        return false;
      return true;
    }

}
