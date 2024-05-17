package io.github.lucklike.convert;

import com.luckyframework.conversion.Interconversion;
import com.luckyframework.conversion.Mapping;
import io.github.lucklike.entity.A;
import io.github.lucklike.entity.B;

public interface ABConvert extends Interconversion<A, B> {

    @Mapping(target = "decs", source = "b_decs")
    @Mapping(target = "price", source = "b_price")
    A toTarget(B source);

    @Mapping(source = "decs", target = "b_decs")
    @Mapping(source = "price", target = "b_price")
    B toSource(A target);
}
