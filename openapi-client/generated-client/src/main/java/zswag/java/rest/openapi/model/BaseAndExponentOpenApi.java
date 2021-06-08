package zswag.java.rest.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import zswag.java.rest.openapi.model.BoolArrayOpenApi;
import zswag.java.rest.openapi.model.I32OpenApi;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BaseAndExponentOpenApi
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-08T12:34:06.016125600+02:00[Europe/Berlin]")


public class BaseAndExponentOpenApi   {
  @JsonProperty("exponent")
  private I32OpenApi exponent = null;

  @JsonProperty("base")
  private I32OpenApi base = null;

  @JsonProperty("unused3")
  private Float unused3 = null;

  @JsonProperty("unused5")
  private BoolArrayOpenApi unused5 = null;

  @JsonProperty("unused1")
  private Integer unused1 = null;

  @JsonProperty("unused2")
  private String unused2 = null;

  public BaseAndExponentOpenApi exponent(I32OpenApi exponent) {
    this.exponent = exponent;
    return this;
  }

  /**
   * Get exponent
   * @return exponent
   **/
  @ApiModelProperty(value = "")
  
    @Valid
    public I32OpenApi getExponent() {
    return exponent;
  }

  public void setExponent(I32OpenApi exponent) {
    this.exponent = exponent;
  }

  public BaseAndExponentOpenApi base(I32OpenApi base) {
    this.base = base;
    return this;
  }

  /**
   * Get base
   * @return base
   **/
  @ApiModelProperty(value = "")
  
    @Valid
    public I32OpenApi getBase() {
    return base;
  }

  public void setBase(I32OpenApi base) {
    this.base = base;
  }

  public BaseAndExponentOpenApi unused3(Float unused3) {
    this.unused3 = unused3;
    return this;
  }

  /**
   * Get unused3
   * @return unused3
   **/
  @ApiModelProperty(value = "")
  
    public Float getUnused3() {
    return unused3;
  }

  public void setUnused3(Float unused3) {
    this.unused3 = unused3;
  }

  public BaseAndExponentOpenApi unused5(BoolArrayOpenApi unused5) {
    this.unused5 = unused5;
    return this;
  }

  /**
   * Get unused5
   * @return unused5
   **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BoolArrayOpenApi getUnused5() {
    return unused5;
  }

  public void setUnused5(BoolArrayOpenApi unused5) {
    this.unused5 = unused5;
  }

  public BaseAndExponentOpenApi unused1(Integer unused1) {
    this.unused1 = unused1;
    return this;
  }

  /**
   * Get unused1
   * @return unused1
   **/
  @ApiModelProperty(value = "")
  
    public Integer getUnused1() {
    return unused1;
  }

  public void setUnused1(Integer unused1) {
    this.unused1 = unused1;
  }

  public BaseAndExponentOpenApi unused2(String unused2) {
    this.unused2 = unused2;
    return this;
  }

  /**
   * Get unused2
   * @return unused2
   **/
  @ApiModelProperty(value = "")
  
    public String getUnused2() {
    return unused2;
  }

  public void setUnused2(String unused2) {
    this.unused2 = unused2;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseAndExponentOpenApi baseAndExponent = (BaseAndExponentOpenApi) o;
    return Objects.equals(this.exponent, baseAndExponent.exponent) &&
        Objects.equals(this.base, baseAndExponent.base) &&
        Objects.equals(this.unused3, baseAndExponent.unused3) &&
        Objects.equals(this.unused5, baseAndExponent.unused5) &&
        Objects.equals(this.unused1, baseAndExponent.unused1) &&
        Objects.equals(this.unused2, baseAndExponent.unused2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(exponent, base, unused3, unused5, unused1, unused2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BaseAndExponentOpenApi {\n");
    
    sb.append("    exponent: ").append(toIndentedString(exponent)).append("\n");
    sb.append("    base: ").append(toIndentedString(base)).append("\n");
    sb.append("    unused3: ").append(toIndentedString(unused3)).append("\n");
    sb.append("    unused5: ").append(toIndentedString(unused5)).append("\n");
    sb.append("    unused1: ").append(toIndentedString(unused1)).append("\n");
    sb.append("    unused2: ").append(toIndentedString(unused2)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
