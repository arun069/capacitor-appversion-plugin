export interface appversionPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
