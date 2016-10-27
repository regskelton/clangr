package TasklistService.health;

/**
 * Created by reg on 14/10/2016.
 */

import com.codahale.metrics.health.HealthCheck;

public class TasklistHealth extends HealthCheck {
    private final int maxLength;

    public TasklistHealth(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    protected Result check() throws Exception {
        if (maxLength < 0) {
            return Result.unhealthy("maxLength is negative");
        }
        return Result.healthy();
    }
}
